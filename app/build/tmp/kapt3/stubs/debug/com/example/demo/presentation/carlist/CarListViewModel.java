package com.example.demo.presentation.carlist;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/example/demo/presentation/carlist/CarListViewModel;", "Landroidx/lifecycle/ViewModel;", "getCarsUseCase", "Lcom/example/demo/domain/usecase/GetCarsUseCase;", "(Lcom/example/demo/domain/usecase/GetCarsUseCase;)V", "_isRefreshing", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_uiState", "Lcom/example/demo/presentation/carlist/CarListUiState;", "isRefreshing", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "<set-?>", "", "selectedBrandIndex", "getSelectedBrandIndex", "()I", "setSelectedBrandIndex", "(I)V", "selectedBrandIndex$delegate", "Landroidx/compose/runtime/MutableState;", "uiState", "getUiState", "loadCars", "", "_marke", "", "refresh", "_make", "selectBrand", "index", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CarListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.demo.domain.usecase.GetCarsUseCase getCarsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.demo.presentation.carlist.CarListUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.demo.presentation.carlist.CarListUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isRefreshing = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState selectedBrandIndex$delegate = null;
    
    @javax.inject.Inject()
    public CarListViewModel(@org.jetbrains.annotations.NotNull()
    com.example.demo.domain.usecase.GetCarsUseCase getCarsUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.demo.presentation.carlist.CarListUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing() {
        return null;
    }
    
    public final int getSelectedBrandIndex() {
        return 0;
    }
    
    private final void setSelectedBrandIndex(int p0) {
    }
    
    public final void selectBrand(int index) {
    }
    
    public final void loadCars(@org.jetbrains.annotations.NotNull()
    java.lang.String _marke) {
    }
    
    public final void refresh(@org.jetbrains.annotations.NotNull()
    java.lang.String _make) {
    }
}