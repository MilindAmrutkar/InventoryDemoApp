package com.backtocoding.inventorydemoapp.domain.usecases

interface UseCase<out Type, in Params> where Type : Any {
    suspend operator fun invoke(params: Params): Type
}