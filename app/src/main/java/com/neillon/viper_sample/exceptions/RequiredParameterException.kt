package com.neillon.viper_sample.exceptions

class RequiredParameterException(var name: String) : Exception(name) {
    init {
        name = "Parameter $name must be informed"
    }
}