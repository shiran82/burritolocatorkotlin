package com.example.shiranpeer.burritolocator;

import com.example.shiranpeer.burritolocator.presenter.PlacesOnMapActivityPresenter;
import com.example.shiranpeer.burritolocator.screen.PlacesOnMapActivityMvpView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlacesOnMapActivityPresenterTest {
    @Mock
    private PlacesOnMapActivityMvpView mockMvpView;
    private PlacesOnMapActivityPresenter presenter;

    @Before
    public void setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());

        presenter = new PlacesOnMapActivityPresenter(mockMvpView);
    }

    @Test
    public void testRequestMap() {
        when(mockMvpView.isNetworkAvailable()).thenReturn(true);

        presenter.requestMaps();
        verify(mockMvpView, never()).showNetworkErrorMessage();
        verify(mockMvpView).showMap();
    }

    @Test
    public void testRequestMapNoNetwork() {
        when(mockMvpView.isNetworkAvailable()).thenReturn(false);

        presenter.requestMaps();
        verify(mockMvpView).showNetworkErrorMessage();
        verify(mockMvpView, never()).showMap();
    }

}