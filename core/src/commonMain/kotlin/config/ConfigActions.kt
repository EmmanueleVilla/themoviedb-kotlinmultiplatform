package config

import redux.Action


internal sealed class ConfigActions : Action {
    data class Init(val placeholder: Boolean) : ConfigActions()
    data class ConfigModelRetrieved(val model: ConfigModel) : ConfigActions()
}