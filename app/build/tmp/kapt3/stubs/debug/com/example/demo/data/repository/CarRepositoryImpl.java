package com.example.demo.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/demo/data/repository/CarRepositoryImpl;", "Lcom/example/demo/domain/repository/CarRepository;", "api", "Lcom/example/demo/data/remote/CarQueryApi;", "(Lcom/example/demo/data/remote/CarQueryApi;)V", "getCars", "", "Lcom/example/demo/domain/model/Car;", "make", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRandomImageForBrand", "brand", "randomPrice", "", "mark", "app_debug"})
public final class CarRepositoryImpl implements com.example.demo.domain.repository.CarRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.demo.data.remote.CarQueryApi api = null;
    
    public CarRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.demo.data.remote.CarQueryApi api) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCars(@org.jetbrains.annotations.NotNull()
    java.lang.String make, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.demo.domain.model.Car>> $completion) {
        return null;
    }
    
    private final int randomPrice(java.lang.String mark) {
        return 0;
    }
    
    private final java.lang.String getRandomImageForBrand(java.lang.String brand) {
        return null;
    }
}