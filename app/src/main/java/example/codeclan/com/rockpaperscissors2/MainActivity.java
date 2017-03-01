package example.codeclan.com.rockpaperscissors2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton b_rock, b_paper, b_scissors;
    ImageView rules;
    TextView scoreText1, scoreText2, tv_score;
    ImageView iv_computer;

    int humanScore, computerScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("RockPaperScissors", "onCreateCalled");
        setContentView(R.layout.activity_main);

//        initialise button(s)
        rules = (ImageView) findViewById(R.id.rules);
        b_rock = (ImageButton) findViewById(R.id.b_rock);


        b_paper = (ImageButton) findViewById(R.id.b_paper);
        b_paper.setColorFilter(Color.argb(255, 255, 255, 255));

        b_scissors = (ImageButton) findViewById(R.id.b_scissors);
        b_paper.setColorFilter(Color.argb(255, 255, 255, 255));

        tv_score = (TextView) findViewById(R.id.tv_score);


//        MainActivity.this is a Current Class Reference (context)
//        rules.setOnClickListener(MainActivity.this);
        b_rock.setOnClickListener(MainActivity.this);
        b_paper.setOnClickListener(MainActivity.this);
        b_scissors.setOnClickListener(MainActivity.this);
        tv_score.setOnClickListener(MainActivity.this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_rock:
//                b_rock.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
//                b_rock.setColorFilter(Color.argb(255, 255, 255, 255));
                ImageButton b_rock = (ImageButton)findViewById(R.id.b_rock);
                b_rock.setBackgroundResource(R.drawable.abc);
                String message = playTurn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(humanScore) + " Computer: " + Integer.toString(computerScore));
                Log.d("RockPaperScissors", "b_rock clicked");
                break;
            case R.id.b_paper:
//                b_paper.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
                ImageButton b_paper = (ImageButton)findViewById(R.id.b_paper);
                b_paper.setBackgroundResource(R.drawable.abc_paper);
                String message2 = playTurn("paper");
                Toast.makeText(MainActivity.this, message2, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(humanScore) + " Computer: " + Integer.toString(computerScore));
                Log.d("RockPaperScissors", "b_paper clicked");
                break;
            case R.id.b_scissors:
//                b_scissors.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
                ImageButton b_scissors = (ImageButton)findViewById(R.id.b_scissors);
                b_scissors.setBackgroundResource(R.drawable.abc_scissors);
                String message3 = playTurn("scissors");
                Toast.makeText(MainActivity.this, message3, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(humanScore) + " Computer: " + Integer.toString(computerScore));
                Log.d("RockPaperScissors", "b_scissors clicked");
                break;
        }
    }

    public void onRulesButtonClicked(View v){
        Log.d("RockPaperScissors", "onRulesButtonClicked has been triggered");
        Intent intent = new Intent(MainActivity.this, RulesActivity.class);
        startActivity(intent);
    }


    public String playTurn(String player_choice) {
        String computer_choice = "";
        Random r = new Random();
        int computer_choice_number = r.nextInt(3) + 1;

        //Determine computer choice.
        if (computer_choice_number == 1) {
            computer_choice = "rock";
        }
        if (computer_choice_number == 2) {
            computer_choice = "paper";
        }
        if (computer_choice_number == 3) {
            computer_choice = "scissors";
        }

        //Set computer choice image
        if (computer_choice == "rock") {
            ImageView image = (ImageView) findViewById(R.id.iv_computer);
            image.setImageResource(R.drawable.rock_new);
        }

        if (computer_choice == "paper") {
            ImageView image = (ImageView) findViewById(R.id.iv_computer);
            image.setImageResource(R.drawable.paper_new);
        }

        if (computer_choice == "scissors") {
            ImageView image = (ImageView) findViewById(R.id.iv_computer);
            image.setImageResource(R.drawable.scissors_new);
        }

        //Check who wins
        if (computer_choice == player_choice) {
            return "Draw. Nobody wins.";
        }
        else if (player_choice =="rock" && computer_choice == "scissors" ) {
            humanScore ++;
            return "Rock blunts scissors. You win!";
        }
        else if (player_choice =="rock" && computer_choice == "paper" ) {
            computerScore ++;
            return "Paper covers rock. You lose!";
        }
        else if (player_choice =="scissors" && computer_choice == "rock" ) {
            computerScore ++;
            return "Rock blunts scissors. You Lose!";
        }
        else if (player_choice =="scissors" && computer_choice == "paper" ) {
            humanScore ++;
            return "Scissors cut paper. You win!";
        }
        else if (player_choice =="paper" && computer_choice == "rock" ) {
            humanScore ++;
            return "Paper covers rocks. You win!";
        }
        else if (player_choice =="paper" && computer_choice == "scissors" ) {
            computerScore ++;
            return "scissors cuts paper. You lose!";
        }
        else return "Damned if I know.";
    }
}




