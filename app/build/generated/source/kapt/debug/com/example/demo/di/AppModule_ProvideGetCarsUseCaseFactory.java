package com.example.demo.di;

import com.example.demo.domain.repository.CarRepository;
import com.example.demo.domain.usecase.GetCarsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideGetCarsUseCaseFactory implements Factory<GetCarsUseCase> {
  private final Provider<CarRepository> repositoryProvider;

  public AppModule_ProvideGetCarsUseCaseFactory(Provider<CarRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetCarsUseCase get() {
    return provideGetCarsUseCase(repositoryProvider.get());
  }

  public static AppModule_ProvideGetCarsUseCaseFactory create(
      Provider<CarRepository> repositoryProvider) {
    return new AppModule_ProvideGetCarsUseCaseFactory(repositoryProvider);
  }

  public static GetCarsUseCase provideGetCarsUseCase(CarRepository repository) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideGetCarsUseCase(repository));
  }
}
