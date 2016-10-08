package profbanku.profbanku.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import profbanku.profbanku.R;

public class UpcomingExamFragment extends Fragment {

    private View rootView;
    private WebView mWebView;
    private WebSettings mWebSettings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_upcoming_exam_fragment, container, false);
        mWebView = (WebView) rootView.findViewById(R.id.web_view);
        mWebView.loadUrl("http://ibps.in/");
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        return rootView;
    }


}
