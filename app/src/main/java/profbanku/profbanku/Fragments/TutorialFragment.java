package profbanku.profbanku.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import profbanku.profbanku.GkActivities.GeneralKnowledgeActivity;
import profbanku.profbanku.QuantitativeAptitudeActivities.QuantitativeAptitudeActivity;
import profbanku.profbanku.R;
import profbanku.profbanku.ReasoningActivities.ReasoningActivity;
import profbanku.profbanku.VerbalActivities.VerbalActivity;

public class TutorialFragment extends Fragment {

    private View rootView;
    private Button btn1, btn2, btn3, btn4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_tutorial_fragment, container, false);
        btn1 = (Button) rootView.findViewById(R.id.quantitativeAptitude);
        btn2 = (Button) rootView.findViewById(R.id.reasoning);
        btn3 = (Button) rootView.findViewById(R.id.verbal);
        btn4 = (Button) rootView.findViewById(R.id.generalKnowledge);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), QuantitativeAptitudeActivity.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ReasoningActivity.class));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), VerbalActivity.class));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), GeneralKnowledgeActivity.class));
            }
        });
        return rootView;
    }


}
