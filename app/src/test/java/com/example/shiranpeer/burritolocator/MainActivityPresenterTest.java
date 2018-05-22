package com.example.shiranpeer.burritolocator;

import com.example.shiranpeer.burritolocator.presenter.MainActivityPresenter;
import com.example.shiranpeer.burritolocator.repository.MainActivityDataRepository;
import com.example.shiranpeer.burritolocator.screen.mainActivity.MainActivityMvpView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {
    @Mock
    private MainActivityDataRepository mockRepository;
    @Mock
    private MainActivityMvpView mockMvpView;
    private MainActivityPresenter presenter;

    @Before
    public void setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());

        presenter = new MainActivityPresenter(mockRepository, mockMvpView);
    }

    @Test
    public void requestNearbyPlaces() {
        when(mockMvpView.isNetworkAvailable()).thenReturn(true);
        when(mockRepository.getNearbyPlaces(anyString(), anyString(), anyString(), anyString(),
                anyString())).thenReturn(MockUtil.getPlaces());

        presenter.requestNearbyPlaces("restaurant, food", "-40.123, 74.129",
                "burrito", "distance", "key");

        verify(mockMvpView).hideProgressBar();
        verify(mockMvpView).showNearbyPlaces(anyList(), anyString());
        verify(mockMvpView, never()).showNetworkErrorMessage();
        verify(mockMvpView, never()).showGPSErrorMessage();
    }

    @Test
    public void requestNearbyPlacesError() {
        when(mockMvpView.isNetworkAvailable()).thenReturn(true);
        when(mockRepository.getNearbyPlaces(anyString(), anyString(), anyString(), anyString(),
                anyString())).thenReturn(Observable.error(new Throwable()));

        presenter.requestNearbyPlaces("restaurant, food", "-40.123, 74.129",
                "burrito", "distance", "key");

        verify(mockMvpView).hideProgressBar();
        verify(mockMvpView).showGPSErrorMessage();
        verify(mockMvpView, never()).showNetworkErrorMessage();
        verify(mockMvpView, never()).showNearbyPlaces(anyList(), anyString());
    }

    @Test
    public void requestNearbyPlacesNoNetwork() {
        when(mockMvpView.isNetworkAvailable()).thenReturn(false);
        when(mockRepository.getNearbyPlaces(anyString(), anyString(), anyString(), anyString(),
                anyString())).thenReturn(Observable.error(new Throwable()));

        presenter.requestNearbyPlaces("restaurant, food", "-40.123, 74.129",
                "burrito", "distance", "key");

        verify(mockMvpView, never()).hideProgressBar();
        verify(mockMvpView, never()).showGPSErrorMessage();
        verify(mockMvpView).showNetworkErrorMessage();
        verify(mockMvpView, never()).showNearbyPlaces(anyList(), anyString());
    }

    @Test
    public void requestNearbyPlacesAdditionalResults() {
        when(mockMvpView.isNetworkAvailable()).thenReturn(true);
        when(mockRepository.getNearbyPlacesAdditionalResults(anyString(), anyString())).thenReturn(MockUtil.getPlaces());

        presenter.requestNearbyPlacesAdditionalResults("token", "key");

        verify(mockMvpView).showNearbyAdditionalPlaces(anyList(), anyString());
        verify(mockMvpView, never()).showGPSErrorMessage();
        verify(mockMvpView, never()).showNetworkErrorMessage();
    }

    @Test
    public void requestNearbyPlacesAdditionalResultsNoNetwork() {
        when(mockMvpView.isNetworkAvailable()).thenReturn(false);
        when(mockRepository.getNearbyPlacesAdditionalResults(anyString(), anyString()))
                .thenReturn(new ObservableError<>(Throwable::new));

        presenter.requestNearbyPlacesAdditionalResults("token", "key");

        verify(mockMvpView).showNetworkErrorMessageForLoading();
        verify(mockMvpView, never()).showGPSErrorMessage();
        verify(mockMvpView, never()).showNearbyAdditionalPlaces(anyList(), anyString());
    }
}