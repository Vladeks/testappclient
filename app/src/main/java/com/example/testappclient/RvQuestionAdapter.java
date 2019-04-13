package com.example.testappclient;

import android.preference.EditTextPreference;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.testappclient.model.Question;
import com.example.testappclient.model.QuestionType;

import java.util.ArrayList;
import java.util.Arrays;

public class RvQuestionAdapter extends RecyclerView.Adapter<RvQuestionAdapter.QuestionViewHolder> {

    private ArrayList<Question> questions;

    public RvQuestionAdapter(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.question_item, viewGroup, false);
        QuestionViewHolder questionViewHolder = new QuestionViewHolder(view);
        return questionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder questionViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {

        EditText etQuestion;
        EditText etAnswer;
        Spinner spinQuestionType;
        FloatingActionButton fabAdd;
        FloatingActionButton fabApply;
        LinearLayout llAnswerHolder;
        RadioGroup group;

        public QuestionViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.etQuestion = (EditText) itemView.findViewById(R.id.etQuestionText);
            this.etAnswer = (EditText) itemView.findViewById(R.id.etAnswerText);
            this.spinQuestionType = (Spinner) itemView.findViewById(R.id.spinQuestionType);
            this.fabAdd = (FloatingActionButton) itemView.findViewById(R.id.btnAddAnswer);
            this.fabApply = (FloatingActionButton) itemView.findViewById(R.id.btnApply);
            this.llAnswerHolder = (LinearLayout) itemView.findViewById(R.id.llAnswerHolder);

            ArrayAdapter<String> spinItemsAdapter = new ArrayAdapter<String>(
                    itemView.getContext(),
                    R.layout.support_simple_spinner_dropdown_item,
                    Arrays.asList(QuestionType.names()));
            this.spinQuestionType.setAdapter(spinItemsAdapter);

            fabAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),spinQuestionType.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    QuestionType questionType = QuestionType.valueOf(spinQuestionType.getSelectedItem().toString());
                    switch (questionType) {
                        case MULTI_CHOICE:
                            CheckBox checkBox = new CheckBox(itemView.getContext());
                            checkBox.setText(etAnswer.getText().toString());
                            checkBox.setId(View.generateViewId());
                            llAnswerHolder.addView(checkBox);
                            break;
                        case SINGLE_CHOICE:
                            createGroup();
                            RadioButton button = new RadioButton(itemView.getContext());
                            button.setText(etAnswer.getText().toString());
                            button.setId(View.generateViewId());
                            group.addView(button);
                            break;
                    }
                }
            });
        }

        private void createGroup() {
            if(this.group == null) {
                this.group = new RadioGroup(itemView.getContext());
                this.group.setOrientation(RadioGroup.VERTICAL);
                llAnswerHolder.addView(group);
            }
        }
    }
}
