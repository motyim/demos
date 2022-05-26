cd ../src/main/resources/ || exit

keytool -importcert -keystore server-truststore.p12 -alias client-public -file client.cer -storepass store@123 -noprompt