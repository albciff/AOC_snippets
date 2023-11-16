/**
* Genera un JWT per a MUXv3
**/
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

def clau = 'X19jbGF1REV4ZW1wbGVIYXVyaWVzRGVGZXJTZXJ2aXJMYVF1ZVRIYW5Qcm9wb2Npb25hdF9f'
def algoritme = 'HmacSHA256'
def mac = Mac.getInstance(algoritme)

def header = '{"alg":"HS256","typ":"JWT"}'
def payload = '{"iss":"R_TEST","sub":"INE10ENS","aud":"mux_v3","nbf":1699879147,"iat":1699879147,"exp":1699879447,"user":"12345678Z","name":"Nom Cognom1 Cognom2"}'

def dades = header.bytes.encodeBase64Url().toString() + "." + payload.bytes.encodeBase64Url().toString()

def secretKeySpec = new SecretKeySpec(clau.getBytes(), algoritme)
mac.init(secretKeySpec)
byte[] digest = mac.doFinal(dades.getBytes())

println("JWT [" + dades + "." + digest.encodeBase64Url().toString() + "]")
