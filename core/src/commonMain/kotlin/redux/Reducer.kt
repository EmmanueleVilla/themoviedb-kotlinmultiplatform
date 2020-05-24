package redux

typealias Reducer <S> = (S, Action, Dependencies) -> S

internal val AppStateReducer: Reducer<AppState> = { old, action, dep ->
    AppState()
}
