package redux

import config.ConfigState

typealias Reducer <S> = (S, Action, Dependencies) -> S

internal val AppStateReducer: Reducer<AppState> = { old, action, dep  ->
    AppState()
}