package com.zwt.charsboard.data.remote

data class BookResError(
    val error: Error
)

data class Detail(
    val type: String,
    val domain: String,
    val links: List<Link>,
    val metadata: Metadata,
    val reason: String
)

data class Error(
    val code: Int,
    val details: List<Detail>,
    val errors: List<ErrorX>,
    val message: String,
    val status: String
)

data class ErrorX(
    val domain: String,
    val message: String,
    val reason: String
)

data class Link(
    val description: String,
    val url: String
)

data class Metadata(
    val consumer: String,
    val quota_limit: String,
    val quota_limit_value: String,
    val quota_location: String,
    val quota_metric: String,
    val service: String
)