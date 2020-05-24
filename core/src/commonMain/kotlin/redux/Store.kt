package redux

object DI {
    val store = DefaultStore(initialState = AppState(), reducer = AppStateReducer, epics = AppStateEpic)
}

typealias StoreSubscriber<S> = (S) -> Unit

interface Store<S> {
    fun dispatch(action: Action)
    fun add(subscriber: StoreSubscriber<S>): Boolean
    fun remove(subscriber: StoreSubscriber<S>): Boolean
    fun inject(dependencies: Dependencies): Unit
}

class DefaultStore<S : State>(
    initialState: S,
    private val reducer: Reducer<S>,
    private val epics: List<Epic<S>>
) : Store<S> {
    private lateinit var dependencies: Dependencies

    var state: S = initialState
        set(value) {
            field = value
            subscribers.forEach { it(value) }
        }

    override fun dispatch(action: Action) {
        dependencies.logger.log("Dispatching Action ", action)
        state = reducer(state, action, dependencies)
        dependencies.logger.log("State after dispatch: ", state)
        epics.forEach {
            if (it.invoke(this, state, action, dependencies)) {
                dependencies.logger.log("Async handling started for action: ", action)
            }
        }
    }

    private val subscribers = mutableSetOf<StoreSubscriber<S>>()

    override fun add(subscriber: StoreSubscriber<S>) = subscribers.add(subscriber)
    override fun remove(subscriber: StoreSubscriber<S>) = subscribers.remove(subscriber)
    override fun inject(dependencies: Dependencies) {
        this.dependencies = dependencies
    }
}
