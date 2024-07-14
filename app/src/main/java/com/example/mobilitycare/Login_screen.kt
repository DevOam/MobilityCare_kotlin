package com.example.mobilitycare

import android.content.Intent
import android.os.Bundle
import android.app.AlertDialog
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilitycare.R

class Login_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        // Trouver le bouton par son ID
        val suivantButton: Button = findViewById(R.id.button_suivant)

        // Définir un OnClickListener sur le bouton
        suivantButton.setOnClickListener {
            // Créer et afficher la boîte de dialogue personnalisée
            val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_otp_verification, null)
            val builder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(false)
            val alertDialog = builder.create()

            // Configurer les éléments de la boîte de dialogue
            val btnClose: ImageView = dialogView.findViewById(R.id.btnClose)
            val btnVerify: Button = dialogView.findViewById(R.id.btnVerify)
            val otpDigit1: EditText = dialogView.findViewById(R.id.otpDigit1)
            val otpDigit2: EditText = dialogView.findViewById(R.id.otpDigit2)
            val otpDigit3: EditText = dialogView.findViewById(R.id.otpDigit3)
            val otpDigit4: EditText = dialogView.findViewById(R.id.otpDigit4)
            val tvResend: TextView = dialogView.findViewById(R.id.tvResend)

            // Fermer la boîte de dialogue lorsque le bouton de fermeture est cliqué
            btnClose.setOnClickListener {
                alertDialog.dismiss()
            }

            // Vérifier l'OTP lorsque le bouton "Vérifier maintenant" est cliqué
            btnVerify.setOnClickListener {
                val otpCode = otpDigit1.text.toString() + otpDigit2.text.toString() +
                        otpDigit3.text.toString() + otpDigit4.text.toString()
                // Ajouter la logique de vérification de l'OTP ici
                // Par exemple, envoyer l'OTP au serveur pour vérification

                // Si l'OTP est correct, démarrer l'activité home_screen
                if (otpCode == "1234") { // Remplacez cette condition par votre logique de vérification
                    val intent = Intent(this, Home_screen::class.java)
                    startActivity(intent)
                    alertDialog.dismiss() // Fermer la boîte de dialogue
                }
            }

            // Renvoyer l'OTP lorsque le texte "Renvoyer" est cliqué
            tvResend.setOnClickListener {
                // Ajouter la logique de renvoi de l'OTP ici
                // Par exemple, appeler une API pour renvoyer l'OTP
            }

            alertDialog.show()
        }
    }
}
