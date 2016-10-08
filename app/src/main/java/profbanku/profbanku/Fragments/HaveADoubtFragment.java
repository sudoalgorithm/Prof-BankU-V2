package profbanku.profbanku.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import profbanku.profbanku.R;

public class HaveADoubtFragment extends Fragment {

    private View rootView;
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_have_adoubt_fragment, container, false);
        btn = (Button) rootView.findViewById(R.id.btn_emailUs);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"prof.banku@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "I have a doubt, Please help Me");
                startActivity(intent);

            }
        });
        return rootView;
    }
}
