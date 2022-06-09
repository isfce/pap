import unittest
import mymath

class TestMyMath(unittest.TestCase):
    
    def test_fact(self):
        self.assertEqual(mymath.factorielle(5),120)
        self.assertEqual(mymath.factorielle(0),1)
        self.assertEqual(mymath.factorielle(1),1)
        self.assertEqual(mymath.factorielle(2),2)
        self.assertRaises(AssertionError,mymath.factorielle,-1)
        self.assertRaises(AssertionError,mymath.factorielle,2.3)
        self.assertRaises(AssertionError,mymath.factorielle,'B')
    
    def test_factR(self):
        self.assertEqual(mymath.factorielleR(5),120)
        self.assertEqual(mymath.factorielleR(0),1)
        self.assertEqual(mymath.factorielleR(1),1)
        self.assertEqual(mymath.factorielleR(2),2)
        self.assertRaises(AssertionError,mymath.factorielleR,-1)
        self.assertRaises(AssertionError,mymath.factorielleR,2.3)
        self.assertRaises(AssertionError,mymath.factorielleR,'B')
        
    def test_power(self):
        self.assertEqual(mymath.power( 2, y = 3),8)
        self.assertEqual(mymath.power(5.0),25)
        self.assertEqual(mymath.power(2.0,3),8)
        self.assertEqual(mymath.power(2.0,0),1)
        self.assertEqual(mymath.power(0.0,0),1)
        self.assertEqual(mymath.power(-1.0,0),1)
        self.assertEqual(mymath.power(8.0,1),8)
        self.assertEqual(mymath.power(-2.0,3),-8)
        self.assertEqual(mymath.power(-2,3),-8)
        self.assertEqual(mymath.power(2.0,111),2.0**111)
        #self.assertRaises(AssertionError,mymath.power,2,3)
        self.assertRaises(AssertionError,mymath.power,2.0,3.1)
        self.assertRaises(AssertionError,mymath.power,2.0,'A')
        self.assertRaises(AssertionError,mymath.power,2.0,-5)    
    
    def test_power2(self):
        self.assertEqual(mymath.power2(2,1),2)
        self.assertEqual(mymath.power2(2.0,3),8)
        self.assertEqual(mymath.power2(2.0,0),1)
        self.assertEqual(mymath.power2(0.0,0),1)
        self.assertEqual(mymath.power2(-1.0,0),1)
        self.assertEqual(mymath.power2(8.0,1),8)
        self.assertEqual(mymath.power2(-2.0,3),-8)
        self.assertEqual(mymath.power2(2.0,111),2.0**111)
        self.assertEqual(mymath.power2(2,-1),0.5)
        self.assertEqual(mymath.power2(-2,-3),-0.125)
        self.assertEqual(mymath.power2(-1,-1),-1)
        self.assertEqual(mymath.power2(1,-5),1)
        self.assertEqual(mymath.power2(-2,-2),(-2)**-2)
        self.assertRaises(AssertionError,mymath.power2,2.0,3.1)
        self.assertRaises(AssertionError,mymath.power2,2.0,'A')
        self.assertRaises(ZeroDivisionError,mymath.power2,0,-1)
    
    def test_power3(self):
        self.assertEqual(mymath.power3(2,1),2)
        self.assertEqual(mymath.power3(2.0,3),8)
        self.assertEqual(mymath.power3(2.0,0),1)
        self.assertEqual(mymath.power3(0.0,0),1)
        self.assertEqual(mymath.power3(-1.0,0),1)
        self.assertEqual(mymath.power3(8.0,1),8)
        self.assertEqual(mymath.power3(-2.0,3),-8)
        self.assertEqual(mymath.power3(2.0,111),2.0**111)
        self.assertEqual(mymath.power3(2,-1),0.5)
        self.assertEqual(mymath.power3(-2,-3),-0.125)
        self.assertEqual(mymath.power3(-1,-1),-1)
        self.assertEqual(mymath.power3(1,-5),1)
        self.assertEqual(mymath.power3(-2,-2),(-2)**-2)
        self.assertRaises(AssertionError,mymath.power3,2.0,3.1)
        self.assertRaises(AssertionError,mymath.power3,2.0,'A')
        self.assertRaises(ZeroDivisionError,mymath.power3,0,-1)
        
    def test_pgcd(self):
        self.assertEqual(mymath.pgcd(5,5),5)
        self.assertEqual(mymath.pgcd(15,9),3)
        self.assertEqual(mymath.pgcd(9,15),3)
        self.assertEqual(mymath.pgcd(23,19),1)
        self.assertRaises(AssertionError,mymath.pgcd,7,0)
        self.assertRaises(AssertionError,mymath.pgcd,-7,7)
        self.assertRaises(AssertionError,mymath.pgcd,0,0)
        self.assertRaises(AssertionError,mymath.pgcd,5.0,6.0)
    
    def test_nbUn(self):
        self.assertEqual(mymath.nbUn(0),0)
        self.assertEqual(mymath.nbUn(1),1)
        self.assertEqual(mymath.nbUn(8),1)
        self.assertEqual(mymath.nbUn(255),8)
        self.assertRaises(AssertionError,mymath.nbUn,-1)
        self.assertRaises(AssertionError,mymath.nbUn,'ABC')
        
    def test_Utf8(self):
        self.assertEqual(mymath.nbBytesUtf8('A'),1)
        self.assertEqual(mymath.nbBytesUtf8('é'),2)
        self.assertEqual(mymath.nbBytesUtf8('€'),3)
        self.assertRaises(AssertionError,mymath.nbBytesUtf8,'ABC')
        self.assertRaises(AssertionError,mymath.nbBytesUtf8,2)
        
    def test_Utf8_V2(self):
        self.assertEqual(mymath.nbBytesUtf8_V2('A'),1)
        self.assertEqual(mymath.nbBytesUtf8_V2('é'),2)
        self.assertEqual(mymath.nbBytesUtf8_V2('€'),3)
        self.assertRaises(AssertionError,mymath.nbBytesUtf8_V2,'ABC')
        self.assertRaises(AssertionError,mymath.nbBytesUtf8_V2,2)

if __name__ == "__main__":
    unittest.main()