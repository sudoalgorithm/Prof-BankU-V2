package profbanku.profbanku.QuantitativeAptitudeActivities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import profbanku.profbanku.R;

public class QuantitativeAptitudeActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private ListView mListView;
    private String[] index = {"Basic Numbers","Basic Calculations", "Percentage Basic","Profit - Loss", "CI & SI", "Ratio & Mixture", "Speed - Distance - Time", "Boats & Streams", "Trains & Platforms", "Time & Work", "HCF & LCM", "Averages", "Algebra", "Geometry", "Mensuration 2D", "Mensuration 3D","DI", "Probability", "Permutations & Combinations", "Trigonometry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantitative_aptitude);
        toolbar();

        mListView = (ListView) findViewById(R.id.listView_qa);
        mListView.setAdapter(new ArrayAdapter<String>(this,R.layout.list_item_row, R.id.tv_list_item_row,index));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, BasicNumbersActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, BasicCalculationsActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this,PercentageBasicActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this,ProfitLossActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this,CISIActiviy.class));
                        break;
                    case 5:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, RatioMixtureActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, SpeedDistanceTimeActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, BoatsStreamsActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, TrainsPlatformsActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, TimeWorkActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, HCFLCMActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, AveragesActivity.class));
                        break;
                    case 12:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, AlgebraActivity.class));
                        break;
                    case 13:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, GeometryActivity.class));
                        break;
                    case 14:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, Mensuration2DActivity.class));
                        break;
                    case 15:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, Mensuration3DActivity.class));
                        break;
                    case 16:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, DIActivity.class));
                        break;
                    case 17:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, ProbabilityActivity.class));
                        break;
                    case 18:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, PermutationsCombinationsActivity.class));
                        break;
                    case 19:
                        startActivity(new Intent(QuantitativeAptitudeActivity.this, TrigonometryActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void toolbar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        if (mActionBar != null){
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setDisplayShowHomeEnabled(true);
            mActionBar.setDisplayShowTitleEnabled(false);
        }
    }


}
