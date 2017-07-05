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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import static example.codeclan.com.rockpaperscissors2.R.drawable.paper;
import static example.codeclan.com.rockpaperscissors2.R.drawable.rock;
import static example.codeclan.com.rockpaperscissors2.R.drawable.scissors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton rock, paper, scissors, lizard, spock;
    ImageView rules;
    TextView scoreText1, scoreText2, tv_score;
    ImageView iv_computer;
    ArrayList<String> optionsArray;
    String computer_choice;
    String player_choice;

    int humanScore, computerScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("RockPaperScissors", "onCreateCalled");
        setContentView(R.layout.activity_main);

//        initialise button(s)
        rules = (ImageView) findViewById(R.id.rules);
        rock = (ImageButton) findViewById(R.id.rock);
        paper = (ImageButton) findViewById(R.id.paper);
//        b_paper.setColorFilter(Color.argb(255, 255, 255, 255));
        scissors = (ImageButton) findViewById(R.id.scissors);
        tv_score = (TextView) findViewById(R.id.tv_score);
        lizard = (ImageButton) findViewById(R.id.lizard);
        spock = (ImageButton) findViewById(R.id.spock);

        computer_choice = "";
        player_choice = "";

        optionsArray = new ArrayList<String>();
        optionsArray.add("rock");
        optionsArray.add("paper");
        optionsArray.add("scissors");
        optionsArray.add("lizard");
        optionsArray.add("spock");


//        MainActivity.this is a Current Class Reference (context)
        rules.setOnClickListener(MainActivity.this);

        rock.setOnClickListener(MainActivity.this);
        paper.setOnClickListener(MainActivity.this);
        scissors.setOnClickListener(MainActivity.this);
        lizard.setOnClickListener(MainActivity.this);
        spock.setOnClickListener(MainActivity.this);
        tv_score.setOnClickListener(MainActivity.this);
    }

        @Override
    public void onClick(View v) {
        if(v.getId() == R.id.rock){
            player_choice = "rock";
        }
        if(v.getId() == R.id.rock){
            player_choice = "paper";
        }
        if(v.getId() == R.id.rock){
            player_choice = "scissors";
        }
        if(v.getId() == R.id.rock){
            player_choice = "lizard";
        }
        if(v.getId() == R.id.rock){
            player_choice = "spock";
        }
        takeTurn();
    }

    public void takeTurn(){
        notifyPlayerChoice();
        getComputerChoice();
        setComputerChoiceImage();
        checkWinner();
        updateScore();
    }

    public void notifyPlayerChoice(){
        String message = player_choice;
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    public void getComputerChoice() {
        Random r = new Random();
        int computer_choice_number = r.nextInt(5) + 1;
        computer_choice = optionsArray.get(computer_choice_number);
        if (computer_choice_number == 1) {
            this.computer_choice = "rock";
        }
        if (computer_choice_number == 2) {
            computer_choice = "paper";
        }
        if (computer_choice_number == 3) {
            computer_choice = "scissors";
        }
        if (computer_choice_number == 4) {
            computer_choice = "lizard";
        }
        if (computer_choice_number == 5) {
            computer_choice = "spock";
        }
    }

    public void setComputerChoiceImage() {
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

        if (computer_choice == "lizard") {
            ImageView image = (ImageView) findViewById(R.id.iv_computer);
            image.setImageResource(R.drawable.lizard_new);
        }

        if (computer_choice == "spock") {
            ImageView image = (ImageView) findViewById(R.id.iv_computer);
            image.setImageResource(R.drawable.spock_new);
        }
    }

    public String checkWinner() {
        if (computer_choice == player_choice) {
            return "Draw. Nobody wins.";
        } else if (player_choice == "rock" && computer_choice == "scissors") {
            humanScore++;
            return "Rock blunts scissors. You win!";
        } else if (player_choice == "rock" && computer_choice == "paper") {
            computerScore++;
            return "Paper covers rock. You lose!";
        } else if (player_choice == "rock" && computer_choice == "lizard") {
            humanScore++;
            return "Rock smashes lizard. You win!";
        } else if (player_choice == "rock" && computer_choice == "spock") {
            computerScore++;
            return "Spock vaporises rock. You lose!";
        } else if (player_choice == "scissors" && computer_choice == "rock") {
            computerScore++;
            return "Rock blunts scissors. You Lose!";
        } else if (player_choice == "scissors" && computer_choice == "paper") {
            humanScore++;
            return "Scissors cut paper. You win!";
        } else if (player_choice == "scissors" && computer_choice == "lizard") {
            humanScore++;
            return "Scissors decapitate lizard. You win!";
        } else if (player_choice == "scissors" && computer_choice == "spock") {
            humanScore++;
            return "Spock smashes scissors. You lose!";
        } else if (player_choice == "paper" && computer_choice == "rock") {
            humanScore++;
            return "Paper covers rocks. You win!";
        } else if (player_choice == "paper" && computer_choice == "scissors") {
            computerScore++;
            return "scissors cuts paper. You lose!";
        } else if (player_choice == "paper" && computer_choice == "lizard") {
            computerScore++;
            return "lizard eats paper. You lose!";
        } else if (player_choice == "paper" && computer_choice == "spock") {
            computerScore++;
            return "Paper disproves Spock. You win!";
        } else if (player_choice == "lizard" && computer_choice == "rock") {
            humanScore++;
            return "Rock smashes lizard. You lose!!";
        } else if (player_choice == "lizard" && computer_choice == "scissors") {
            computerScore++;
            return "scissors decapitates lizard. You lose!";
        } else if (player_choice == "lizard" && computer_choice == "paper") {
            computerScore++;
            return "lizard eats paper. You win!";
        } else if (player_choice == "lizard" && computer_choice == "spock") {
            computerScore++;
            return "Lizard poisons Spock. You win!";
        } else if (player_choice == "spock" && computer_choice == "rock") {
            humanScore++;
            return "Spock vaporises rock. You win!";
        } else if (player_choice == "spock" && computer_choice == "scissors") {
            computerScore++;
            return "spock smashes scissors. You win!";
        } else if (player_choice == "spock" && computer_choice == "lizard") {
            computerScore++;
            return "lizard poisons spock. You lose!";
        } else if (player_choice == "spock" && computer_choice == "paper") {
            computerScore++;
            return "Paper disproves Spock. You lose!";
        } else return "Damned if I know.";
    }

    public void updateScore(){
        tv_score.setText("Score Human: " + Integer.toString(humanScore) + " Computer: " + Integer.toString(computerScore));
    }




//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.b_rock:
////                b_rock.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
////                b_rock.setColorFilter(Color.argb(255, 255, 255, 255));
//                ImageButton b_rock = (ImageButton) findViewById(R.id.b_rock);
//                b_rock.setBackgroundResource(R.drawable.abc);
//
//                tv_score.setText("Score Human: " + Integer.toString(humanScore) + " Computer: " + Integer.toString(computerScore));
//                Log.d("RockPaperScissors", "b_rock clicked");
//                break;
//            case R.id.b_paper:
////                b_paper.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
//                ImageButton b_paper = (ImageButton) findViewById(R.id.b_paper);
//                b_paper.setBackgroundResource(R.drawable.abc_paper);
//                String message2 = playTurn("paper");
//                Toast.makeText(MainActivity.this, message2, Toast.LENGTH_SHORT).show();
//                tv_score.setText("Score Human: " + Integer.toString(humanScore) + " Computer: " + Integer.toString(computerScore));
//                Log.d("RockPaperScissors", "b_paper clicked");
//                break;
//            case R.id.b_scissors:
////                b_scissors.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
//                ImageButton b_scissors = (ImageButton) findViewById(R.id.b_scissors);
//                b_scissors.setBackgroundResource(R.drawable.abc_scissors);
//                String message3 = playTurn("scissors");
//                Toast.makeText(MainActivity.this, message3, Toast.LENGTH_SHORT).show();
//                tv_score.setText("Score Human: " + Integer.toString(humanScore) + " Computer: " + Integer.toString(computerScore));
//                Log.d("RockPaperScissors", "b_scissors clicked");
//                break;
//            case R.id.b_lizard:
////                b_scissors.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
//                ImageButton b_lizard = (ImageButton) findViewById(R.id.b_lizard);
//                b_lizard.setBackgroundResource(R.drawable.abc_lizard);
//                String message4 = playTurn("lizard");
//                Toast.makeText(MainActivity.this, message4, Toast.LENGTH_SHORT).show();
//                tv_score.setText("Score Human: " + Integer.toString(humanScore) + " Computer: " + Integer.toString(computerScore));
//                Log.d("RockPaperScissors", "b_lizard clicked");
//                break;
//            case R.id.b_spock:
////                b_scissors.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
//                ImageButton b_spock = (ImageButton) findViewById(R.id.b_spock);
//                b_spock.setBackgroundResource(R.drawable.abc_spock);
//                String message5 = playTurn("spock");
//                Toast.makeText(MainActivity.this, message5, Toast.LENGTH_SHORT).show();
//                tv_score.setText("Score Human: " + Integer.toString(humanScore) + " Computer: " + Integer.toString(computerScore));
//                Log.d("RockPaperScissors", "b_spock clicked");
//                break;
//        }
//    }

    public void onRulesButtonClicked(View v) {
        Log.d("RockPaperScissors", "onRulesButtonClicked has been triggered");
        Intent intent = new Intent(MainActivity.this, RulesActivity.class);
        startActivity(intent);
    }










}





