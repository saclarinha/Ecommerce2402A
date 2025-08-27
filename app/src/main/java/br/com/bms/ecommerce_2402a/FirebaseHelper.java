package br.com.bms.ecommerce_2402a;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;

public class FirebaseHelper {

    private static FirebaseAuth auth;
    private static DatabaseReference databaseReference;
    //private static StorageReference storageReference;

//    public static StorageReference getStorageReference(){
//        if(storageReference == null){
//            storageReference = FirebaseStorage.getInstance().getReference();
//        }
//        return storageReference;
//    }

    public static String getIdFirebase(){
        return getAuth().getUid();
    }

    public static DatabaseReference getDatabaseReference(){
        if(databaseReference == null){
            databaseReference = FirebaseDatabase.getInstance().getReference();
        }
        return databaseReference;
    }

    public static FirebaseAuth getAuth(){
        if(auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }

    public static boolean getAutenticado(){
        return getAuth().getCurrentUser() != null;
    }

    //27/08
    public static String validar_Erros(String erro){
        String mensagem = "";
        //Verificar o erro em seu idioma nativo
        if(erro.contains("There is no user record corresponding to this identifier")){
            //Traduzir o erro para português
            mensagem = "Nenhuma conta encontrada com esse email";
        }
        else if (erro.contains("The email address is badly formatted")){
            mensagem = "Insira um email válido.";
        }
        else if (erro.contains("The password is invalid or the user does not have a password")) {
            mensagem = "Senha inválida, tente novamente";
        }
        else if (erro.contains("The email address is already in use by another account")) {
            mensagem = "Este email já está em uso.";
        }
        else if (erro.contains("Password should be at least 6 characters")){
            mensagem = "Insira uma senha mais forte";
        }
        else if (erro.contains("The supplied auth credential is incorrect, malformed or has expired")) {
            mensagem = "Informações inseridas incorretas, mal formadas ou invalidas, tente novamente.";
        }
        else if (erro.contains("Network error")) {
            mensagem = "Erro de conexão com a internet. Verifique sua conexão e tente novamente.";
        }
        else if (erro.contains("We have blocked all requests from this device due to unusual activity.")) {
            mensagem = "Detectamos atividade incomum a partir desse dispositivo. Tente novamente mais tarde ou entre em contato com o suporte";
        }
        else {
            mensagem = "Ocorreu um erro durante a autenticação";
        }
        return mensagem;

    }
}

