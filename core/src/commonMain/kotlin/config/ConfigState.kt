package config

import config.types.AppInfo
import config.types.ConfigModel
import redux.State

data class ConfigState(
    var AppInfo: AppInfo = AppInfo(),
    var configModel: ConfigModel = ConfigModel()
) : State
