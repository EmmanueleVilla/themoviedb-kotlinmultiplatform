package config

import redux.Reducer

internal val ConfigReducer: Reducer<ConfigState> = { old, action, dep ->
    when (action) {
        is ConfigActions.Init -> {
            ConfigState()
        }
        is ConfigActions.ConfigModelRetrieved -> {
            old.copy(configModel = action.model)
        }
        else -> old
    }
}