package com.example.demo.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/demo/data/remote/CarQueryApi;", "", "getModels", "Lcom/example/demo/data/remote/dto/CarModelsResponse;", "make", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CarQueryApi {
    
    @retrofit2.http.GET(value = "?cmd=getModels")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getModels(@retrofit2.http.Query(value = "make")
    @org.jetbrains.annotations.NotNull()
    java.lang.String make, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.demo.data.remote.dto.CarModelsResponse> $completion);
}