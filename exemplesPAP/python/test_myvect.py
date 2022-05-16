import unittest
import myvect

class TestMyMath(unittest.TestCase):
    
    def test_EstTrie(self):
        v=[1,2,3,4,5]
        self.assertTrue(myvect.estTrie(v))
        v=[1]
        self.assertTrue(myvect.estTrie(v))
        v=[]
        self.assertTrue(myvect.estTrie(v))
        v=[2,1,2,3,4,5]
        self.assertFalse(myvect.estTrie(v))
        v=[1,1,2,3,4,5,1]
        self.assertFalse(myvect.estTrie(v))
    
    def test_TriBulle(self):
        v0  = []
        v0T = []
        myvect.triBulles(v0)
        self.assertEqual(v0,v0T)
        
        v1  = [9,7,6,5]
        v1T = [5,6,7,9]
        myvect.triBulles(v1)
        self.assertEqual(v1,v1T)
        
        v2  = [8]
        v2T = [8]
        myvect.triBulles(v2)
        self.assertEqual(v2,v2T)
        
        v3  = [1,2,3]
        v3T = [1,2,3]
        myvect.triBulles(v3)
        self.assertEqual(v3,v3T)
        
    
    def test_RechercheBin(self):
        v1 = [ 3, 5, 8, 20, 30 ];
        self.assertEqual(myvect.rechercheBin(v1,5),1)
        self.assertEqual(myvect.rechercheBin(v1,30),4)
        self.assertEqual(myvect.rechercheBin(v1,3),0)
        self.assertEqual(myvect.rechercheBin(v1,20),3)
        self.assertEqual(myvect.rechercheBin(v1,-5),-1)
        self.assertEqual(myvect.rechercheBin(v1,19),-1)
        self.assertEqual(myvect.rechercheBin(v1,32),-1)
       
        
   
if __name__ == "__main__":
    unittest.main()