package me.gilo.woodroid.repo


import retrofit2.Call

interface APIMethod<T> {
    fun create(data: T): Call<T>
    operator fun get(id: Int): Call<T>
    fun all(): Call<List<T>>
    fun update(id: Int, data: T): Call<T>
    fun delete(id: Int): Call<T>
    fun delete(id: Int, force: Boolean): Call<T>

}
