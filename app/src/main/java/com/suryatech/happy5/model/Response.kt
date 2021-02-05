package com.suryatech.happy5.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Response(

		@field:Expose
	@field:SerializedName("page")
	val page: Int,

		@field:Expose
	@field:SerializedName("total_pages")
	val totalPages: Int,

		@field:Expose
	@field:SerializedName("results")
	val results: List<ResultsItem>,

		@field:Expose
	@field:SerializedName("total_results")
	val totalResults: Int
)

