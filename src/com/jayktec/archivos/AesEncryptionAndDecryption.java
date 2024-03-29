
//////////////////////////////////////////////////////////////
//                    www.jayktec.com.ve                    //
//////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////
//                Protocolo.java                            //
//                   Descripcion                            // 
//             Pantalla para el juego                       //
//////////////////////////////////////////////////////////////
//      Autor            Fecha           Motivo             //  
//    Luis Diaz       09/03/2016      Version Inicial       //
//   Yisheng León     14/03/2016      Cambios en recibir()    //
//////////////////////////////////////////////////////////////

 
package com.jayktec.archivos;
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec; 
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;


 


	/**
	 * el programa procede a encriptar los datos almacenados en un archivo xmml donde los niños guardaran su perfil y su progreso en el juego
	 * 
	 * @author luis
	 *
	 */
public class AesEncryptionAndDecryption {
	
	/** The Constant alg. */
    private final static String alg = "AES";
    
    /** The Constant keyValue. */
    private static final byte[] keyValue = new byte[]{'9', '2', 'A', 'E', '3', '1', 'A', '7', '9', 'F', 'E', 'E', 'B', '2', 'A', '3'};
    
//9 2 A E 3 1 A 7 9 F E E B 2 A 3
//92AE31A79FEEB2A3

    /** The Constant cI. */
    private final static String cI = "AES/CBC/PKCS5Padding";
    
    /** The Constant iv. */
    private static final String iv = "0123456789ABCDEF";

    /**
     * Encryption.
     *
     * @param data the data
     * @return the byte[]
     */
    public static byte[] encryption(String data) throws Exception{
        try {

            Cipher cipher = Cipher.getInstance(cI);
            Key key = generateKey();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return encodeBase64(encrypted);

        } catch (Exception ex) {
        	Logger.getLogger(AesEncryptionAndDecryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * este sera el desencriptador incluido en el programa para que se pueda leer al momento de ser solicitado
     *
     * @param encryptedData the encrypted data
     * @return the string
     */
    public static String decryption(String encryptedData) {
        try {

            Cipher cipher = Cipher.getInstance(cI);
            Key key = generateKey();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());

            byte[] decodedValue = decodeBase64(encryptedData);
            cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(decodedValue);
            return new String(decrypted);

        } catch (Exception ex) {
        	Logger.getLogger(AesEncryptionAndDecryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Genera una key para el encriptadoor y el desencriptador
     *
     * @return the key
     */
    private static Key generateKey() {
        Key key = new SecretKeySpec(keyValue, alg);
        return key;
    }

}
