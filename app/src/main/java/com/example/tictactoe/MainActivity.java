package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //0-X,1-0
    boolean a=true;
    int[] s ={2,2,2,2,2,2,2,2,2};
    int[][] p={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int t=0;
//2 means empty
    public void whenyouclick(View v)
    {
        ImageView i=(ImageView) v;
        int k= Integer.parseInt(i.getTag().toString());
        i.setTranslationY(-1000f);
        if(!a)
        {
            Restart(v);
        }
        if(s[k]==2)
        {
            s[k]=t;
            if(t==0)
            {
                i.setImageResource(R.drawable.x);
                t=1;
                TextView status=findViewById(R.id.status);
                status.setText("O's turn");

            }
            else
            {
                i.setImageResource(R.drawable.k);
                t=0;
                TextView status=findViewById(R.id.status);
                status.setText("X's turn");
            }
        }
        i.animate().translationYBy(1000f).setDuration(300);
        int q=0;
        for(int[] l:p)
        {
            String string = "";
            if(s[l[0]]==s[l[1]] && s[l[1]]==s[l[2]] && s[l[0]]!=2)
            {
                a=false;
                q=1;
                if(s[l[0]]==0)
                {
                     string= "X has won the game";
                }
                else
                {
                   string= "O has won the game";
                }
                TextView status=findViewById(R.id.status);
                status.setText(string);
            }

        }
        if(q!=1) {
            int c = 0;
            for (int j = 0; j < s.length; j++) {
                if (s[j] != 2) {
                    c++;
                }
            }
            if (c == 9) {
                Restart(v);
            }
        }

    }

    public void Restart(View v)
    {
        a=true;
         t=0;
        for(int i=0; i<s.length; i++){
            s[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


        TextView status = findViewById(R.id.status);
        status.setText("O's Turn");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}