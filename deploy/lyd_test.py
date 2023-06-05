

import requests
import json
import random
import string

HOST = 'http://8.142.2.194:9000'

def generate_random_mac_address():
    mac = [
           random.randint(0x00, 0x7f),
           random.randint(0x00, 0x7f),
           random.randint(0x00, 0x7f),
           random.randint(0x00, 0xff)]
    
    mac_address = ' '.join(map(lambda x: "%02x" % x, mac))
    return mac_address.upper()


def login():
    url = HOST + '/api/userlogin'
    headers = {'Content-Type': 'application/json'}
    data = {
        "password": "admin123",
        "username": "admin"
    }
    response = requests.post(url, headers=headers, data=json.dumps(data))
    response_json = response.json()
    assert('code' in response_json)
    assert('data' in response_json)
    return response_json['data']



def test_api(token):
    url = HOST + "/api/app/ciphertexts/gor"
    headers = {'Content-Type': 'application/json', 'Authorization': token}
    deviceId = generate_random_mac_address()
    data = {
        "deviceId": deviceId,
        "productType": "S6F",
        "provider": "CLT"
    }
    print(data)
    response = requests.post(url, headers=headers, data=json.dumps(data))
    response_json = response.json()
    print(response_json)


if __name__ == '__main__':
    token = login()
    print('login successed, token: ', token)
    test_api(token)



