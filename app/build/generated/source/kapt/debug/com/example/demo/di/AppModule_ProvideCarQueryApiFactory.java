package com.example.demo.di;

import com.example.demo.data.remote.CarQueryApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class AppModule_ProvideCarQueryApiFactory implements Factory<CarQueryApi> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideCarQueryApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public CarQueryApi get() {
    return provideCarQueryApi(retrofitProvider.get());
  }

  public static AppModule_ProvideCarQueryApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideCarQueryApiFactory(retrofitProvider);
  }

  public static CarQueryApi provideCarQueryApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideCarQueryApi(retrofit));
  }
}
