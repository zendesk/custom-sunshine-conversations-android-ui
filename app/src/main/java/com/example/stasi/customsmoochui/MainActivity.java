package com.example.stasi.customsmoochui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import io.smooch.core.CardSummary;
import io.smooch.core.Conversation;
import io.smooch.core.ConversationEvent;
import io.smooch.core.InitializationStatus;
import io.smooch.core.LoginResult;
import io.smooch.core.LogoutResult;
import io.smooch.core.Message;
import io.smooch.core.MessageAction;
import io.smooch.core.MessageUploadStatus;
import io.smooch.core.PaymentStatus;
import io.smooch.core.Settings;
import io.smooch.core.Smooch;
import io.smooch.core.SmoochCallback;
import io.smooch.core.SmoochConnectionStatus;

import static io.smooch.core.MessageType.List;

public class MainActivity extends AppCompatActivity implements Conversation.Delegate {
    public String conversationText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Smooch.getConversation().setDelegate(MainActivity.this);
    }

    public void renderConversationHistory() {
        TextView textView = findViewById(R.id.textView);
        textView.setText(conversationText);
    }

    public void sendMessage(View view) {
        EditText editText = findViewById(R.id.editText);
        String text = editText.getText().toString();
        Smooch.getConversation().sendMessage(new Message(text));
        editText.setText("", TextView.BufferType.EDITABLE);
        conversationText += text + "\n";
        renderConversationHistory();
    }

    public void getMessages() {
        conversationText = "";
        List<Message> messages;
        for (Message message : messages = Smooch.getConversation().getMessages()) {
            String text = !message.isFromCurrentUser() ? message.getName() + " says " + message.getText() : message.getText();
            conversationText += text + "\n";
        }
    }

    @Override
    public void onMessagesReceived(Conversation conversation, List<Message> list) {
        getMessages();
        renderConversationHistory();
    }

    @Override
    public void onUnreadCountChanged(Conversation conversation, int i) {

    }

    @Override
    public void onMessagesReset(Conversation conversation, List<Message> list) {

    }

    @Override
    public void onMessageSent(Message message, MessageUploadStatus messageUploadStatus) {

    }

    @Override
    public void onConversationEventReceived(ConversationEvent conversationEvent) {

    }

    @Override
    public void onInitializationStatusChanged(InitializationStatus initializationStatus) {
        getMessages();
        renderConversationHistory();
    }

    @Override
    public void onLoginComplete(LoginResult loginResult) {

    }

    @Override
    public void onLogoutComplete(LogoutResult logoutResult) {

    }

    @Override
    public void onPaymentProcessed(MessageAction messageAction, PaymentStatus paymentStatus) {

    }

    @Override
    public boolean shouldTriggerAction(MessageAction messageAction) {
        return true;
    }

    @Override
    public void onCardSummaryLoaded(CardSummary cardSummary) {

    }

    @Override
    public void onSmoochConnectionStatusChanged(SmoochConnectionStatus smoochConnectionStatus) {

    }

    @Override
    public void onSmoochShown() {

    }

    @Override
    public void onSmoochHidden() {

    }
}
