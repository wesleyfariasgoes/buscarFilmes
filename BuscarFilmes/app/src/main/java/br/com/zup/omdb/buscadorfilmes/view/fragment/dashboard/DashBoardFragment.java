package br.com.zup.omdb.buscadorfilmes.view.fragment.dashboard;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import br.com.zup.omdb.buscadorfilmes.R;
import br.com.zup.omdb.buscadorfilmes.view.activity.content.ContentActivity;
import br.com.zup.omdb.buscadorfilmes.view.activity.main.MainActivity;
import br.com.zup.omdb.buscadorfilmes.view.fragment.AbstractFragment;

public class DashBoardFragment extends AbstractFragment implements View.OnClickListener{

    private Button mBtnAddMovie;
    private Button mBtnListMovie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_dash_board, (ViewGroup) null);
        onBackPress(null);
        binds(rootView);
        return rootView;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hideKeyboard();
    }

    private void binds(View rootView) {
        mBtnAddMovie   = (Button) rootView.findViewById(R.id.btn_add_movie);
        mBtnListMovie   = (Button) rootView.findViewById(R.id.btn_lista_movie);

        mBtnAddMovie.setOnClickListener(this);
        mBtnListMovie.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_movie:
                ((MainActivity) getActivity()).showContentFrag();
                break;
            case R.id.btn_lista_movie:
                Intent intent = new Intent(getActivity(), ContentActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
