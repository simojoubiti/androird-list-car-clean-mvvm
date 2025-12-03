package com.example.demo.di;

import com.example.demo.data.remote.CarQueryApi;
import com.example.demo.domain.repository.CarRepository;
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
public final class AppModule_ProvideCarRepositoryFactory implements Factory<CarRepository> {
  private final Provider<CarQueryApi> apiProvider;

  public AppModule_ProvideCarRepositoryFactory(Provider<CarQueryApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public CarRepository get() {
    return provideCarRepository(apiProvider.get());
  }

  public static AppModule_ProvideCarRepositoryFactory create(Provider<CarQueryApi> apiProvider) {
    return new AppModule_ProvideCarRepositoryFactory(apiProvider);
  }

  public static CarRepository provideCarRepository(CarQueryApi api) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideCarRepository(api));
  }
}
