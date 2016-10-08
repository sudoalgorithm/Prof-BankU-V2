package profbanku.profbanku.ReasoningActivities;

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

public class ReasoningActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private ListView mListView;
    private String[] index = {"Syllogisms","Coding - Decoding", "Direction & Distance", "Logical Reasoning", "Number Series", "Ranking & Ordering", "Blood Relation", "Input - Output"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reasoning);
        toolbar();

        mListView = (ListView) findViewById(R.id.listView_ra);
        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item_row, R.id.tv_list_item_row,index));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        startActivity(new Intent(ReasoningActivity.this, SyllogismsActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(ReasoningActivity.this, CodingDecodingActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(ReasoningActivity.this, DirectionDistanceActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(ReasoningActivity.this, LogicalReasoningActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(ReasoningActivity.this, NumberSeriesActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(ReasoningActivity.this, RankingOrderingActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(ReasoningActivity.this, BloodRelationActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(ReasoningActivity.this, InputOutputActivity.class));
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
