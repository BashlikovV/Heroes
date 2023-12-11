package by.bashlikovvv.heroes.data

import java.lang.RuntimeException

sealed class AppException : RuntimeException()

class DetailsNotFoundException : AppException()