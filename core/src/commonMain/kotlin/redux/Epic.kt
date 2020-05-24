package redux

typealias Epic <S> = (Store<S>, S, Action, Dependencies) -> Boolean

internal val AppStateEpic: List<Epic<AppState>> = listOf()
