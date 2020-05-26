package config

import redux.DI

class ConfigInteractor {
    fun init() {
        DI.store.dispatch(action = ConfigActions.Init(true))
    }
}
