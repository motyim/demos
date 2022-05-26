cd ../src/main/resources/ || exit

keytool -exportcert -alias client -file client.cer -keystore client.p12 -storepass client@123