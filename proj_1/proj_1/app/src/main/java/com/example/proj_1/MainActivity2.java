package com.example.proj_1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView textViewBusinessCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewBusinessCard = findViewById(R.id.textViewBusinessCard);

        String firstName = getIntent().getStringExtra("FIRST_NAME");
        String lastName = getIntent().getStringExtra("LAST_NAME");
        boolean isSimple = getIntent().getBooleanExtra("IS_SIMPLE", true);

        if (firstName == null || lastName == null) {
            textViewBusinessCard.setText("Błąd: brak wymaganych danych");
            return;
        }

        String powitanie = firstName.endsWith("a") ? "Szanowna Pani" : "Szanowny Pan";

        StringBuilder businessCard = new StringBuilder();
        businessCard.append(powitanie).append("\n");
        businessCard.append("Imię: ").append(firstName).append("\n");
        businessCard.append("Nazwisko: ").append(lastName).append("\n");

        if (!isSimple) {
            String phone = getIntent().getStringExtra("PHONE");
            String email = getIntent().getStringExtra("EMAIL");
            if (phone != null && !phone.isEmpty()) {
                businessCard.append("Telefon: ").append(phone).append("\n");
            }
            if (email != null && !email.isEmpty()) {
                businessCard.append("Email: ").append(email).append("\n");
            }
        }

        textViewBusinessCard.setText(businessCard.toString());
    }
}
//Modyfikacja: Przed wyświetleniem danych w drugiej aktywności ma sprawdzić czy jest to mężczyzna czy kobieta(sprawdzając czy ostatnia litera imienia kończy się na literę "a") i w zależności od tego wyświetlić na drugiej aktywności przed wyświetlanymi danymi "Szanowny Pan" lub "Szanowna Pani" i dalej resztę danych wyświetlać bez zmian.