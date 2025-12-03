package com.example.demo.presentation.carlist;

import com.example.demo.domain.usecase.GetCarsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class CarListViewModel_Factory implements Factory<CarListViewModel> {
  private final Provider<GetCarsUseCase> getCarsUseCaseProvider;

  public CarListViewModel_Factory(Provider<GetCarsUseCase> getCarsUseCaseProvider) {
    this.getCarsUseCaseProvider = getCarsUseCaseProvider;
  }

  @Override
  public CarListViewModel get() {
    return newInstance(getCarsUseCaseProvider.get());
  }

  public static CarListViewModel_Factory create(Provider<GetCarsUseCase> getCarsUseCaseProvider) {
    return new CarListViewModel_Factory(getCarsUseCaseProvider);
  }

  public static CarListViewModel newInstance(GetCarsUseCase getCarsUseCase) {
    return new CarListViewModel(getCarsUseCase);
  }
}
