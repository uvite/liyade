import sys

def create_license(id,deviceid):
 
  f = open("/product/liyade/exe/"+id+".txt", "a")
  f.write("我是系统生的文件\n 设备Id为")

  f.write(deviceid)
  f.close()


if __name__ == '__main__':
  create_license(sys.argv[1], sys.argv[2])