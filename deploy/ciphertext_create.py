import sys

def create_license(id,deviceid):
 
  f = open("/data/liyade/deploy/"+id+".txt", "a")
  f.write("密文\n 设备Id为")

  f.write(deviceid)
  f.close()


if __name__ == '__main__':
  create_license(sys.argv[1], sys.argv[2])