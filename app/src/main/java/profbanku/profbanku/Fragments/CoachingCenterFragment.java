package profbanku.profbanku.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import profbanku.profbanku.R;

public class CoachingCenterFragment extends Fragment {

    private View rootView;
    private MapView mMapView;
    private GoogleMap googleMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_coaching_center_fragment, container, false);
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                LatLng ll1 = new LatLng(30.741527, 76.799904);
                LatLng ll2 = new LatLng(30.721388, 76.759973);
                LatLng ll3 = new LatLng(30.737632, 76.794675);
                LatLng ll4 = new LatLng(30.727353, 76.771160);
                LatLng ll5 = new LatLng(30.724431, 76.768768);
                LatLng ll6 = new LatLng(30.724118, 76.769390);
                LatLng ll7 = new LatLng(30.751822, 76.768998);
                LatLng ll8 = new LatLng(30.719919, 76.757077);

                googleMap.addMarker(new MarkerOptions().position(ll1).title("Career Launcher").snippet("SCO 78-79\n" +
                        "2nd Floor, Sector 8C, Madhya Marg\n" +
                        "Chandigarh, 160008"));
                googleMap.addMarker(new MarkerOptions().position(ll2).title("Career Launcher").snippet("SCO 451-452\n" +
                        "Himalaya Marg, Sector 35-C\n" +
                        "Chandigarh, 160035"));
                googleMap.addMarker(new MarkerOptions().position(ll3).title("I.B.S").snippet("SCO. 108-109, Top Floor\n" +
                        "Old L Street, Sector 8-C\n" +
                        "8C, Sector 8\n" +
                        "Chandigarh, 160008"));
                googleMap.addMarker(new MarkerOptions().position(ll4).title("IBS - Coaching Institute Chandigarh").snippet("SCO: 13-14-15, First Floor, Sector-34 A\n" +
                        "Sector 21\n" +
                        "Chandigarh, 160022"));
                googleMap.addMarker(new MarkerOptions().position(ll5).title("Gyanm Best Bank PO Coaching in Chandigarh").snippet("SCO-13-14-15\n"+
                        "2nd Floor, Above Domino's, Sector 34 A\n" +
                        "Chandigarh, 160022"));
                googleMap.addMarker(new MarkerOptions().position(ll6).title("Mahendra's No.1 Institute In India (Chandigarh Branch)").snippet("Sub City Center, Sector 34A\n" +
                        "Chandigarh, 160022"));
                googleMap.addMarker(new MarkerOptions().position(ll7).title("AAA Bright Academy Bank PO Coaching Institute").snippet("SCO 66-67, Sector\n" +
                        "15D\n" +
                        "Chandigarh, 160015"));
                googleMap.addMarker(new MarkerOptions().position(ll8).title("EduCorp Consultancy Services Pvt Ltd.").snippet("S.C.O.: 493/494, 2nd Floor, Sector 35/c\n" +
                        "Chandigarh, 160022"));


                CameraPosition cameraPosition = new CameraPosition.Builder().target(ll1).zoom(13).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
