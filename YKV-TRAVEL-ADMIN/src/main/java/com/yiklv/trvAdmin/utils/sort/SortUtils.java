/** 
 * @Project: travel
 * @Title: SortUtils.java  
 * @Package com.yiklv.travel.utils.sort
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月24日 下午11:30:05  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.trvAdmin.utils.sort;

/**
 * <b>Description:</b><br>
 * 
 * @author yanguo001
 * @version 1.0
 * @Note <b>ProjectName:</b> travel <br>
 *       <b>PackageName:</b> com.yiklv.travel.utils.sort <br>
 *       <b>ClassName:</b> SortUtils <br>
 *       <b>Date:</b> 2018年3月24日 下午11:30:05
 */
public class SortUtils {
    /**
     * 
     * <b>Description:</b><br>
     * 冒泡排序
     * 
     * @param array
     * @return
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月24日 下午11:30:17 <br>
     *       <b>Version:</b> 1.0
     */
    public static int[] bubbleSort(int[] array) {
        if (array == null) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    array[i] = array[i] + array[j];
                    array[j] = array[i] - array[j];
                    array[i] = array[i] - array[j];
                }
            }
        }

        return array;
    }

    /**
     * 
     * <b>Description:</b><br>
     * 插入排序
     * 
     * @param array
     * @return
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月24日 下午11:30:39 <br>
     *       <b>Version:</b> 1.0
     */
    public static int[] insertSort(int[] array) {
        if (array == null) {
            return null;
        }

        int i, j, insertNote;// 要插入的数据
        for (i = 1; i < array.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            insertNote = array[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;
            while (j >= 0 && insertNote < array[j]) {
                array[j + 1] = array[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            array[j + 1] = insertNote;// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
        }
        
        
        /*for (int i = 1; i < array.length; i++) {  
            for (int j = i; (j > 0) && (array[j] < array[j - 1]); j--) {  
                SortUtils.swap(array, j, j - 1);  
            }  
        } */

        return array;
    }
    
    public static void swap(int[] array, int start, int end){
        
    }

    /**
     * 
     * <b>Description:</b><br>
     * 选择排序
     * 
     * @param array
     * @return
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月24日 下午11:32:19 <br>
     *       <b>Version:</b> 1.0
     */
    public static int[] selectionSort(int[] array) {
        if (array == null) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            int lowIndex = i;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[lowIndex]) {
                    lowIndex = j;
                }
            }

            SortUtils.swap(array, i, lowIndex);
        }

        return array;
    }

    /**
     * 
     * <b>Description:</b><br>
     * Shell排序
     * 
     * @param array
     * @return
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月24日 下午11:33:08 <br>
     *       <b>Version:</b> 1.0
     */
    public static int[] shellSort(int[] array) {
        if (array == null) {
            return null;
        }

        for (int i = array.length / 2; i > 2; i /= 2) {
            for (int j = 0; j < i; j++) {
                insertSort(array, j, i);
            }
        }

        insertSort(array, 0, 1);

        return array;
    }

    private static void insertSort(int[] array, int start, int inc) {
        for (int i = start + inc; i < array.length; i += inc) {
            for (int j = i; (j >= inc) && (array[j] < array[j - inc]); j -= inc) {
                SortUtils.swap(array, j, j - inc);
            }
        }
    }

    /**
     * 
     * <b>Description:</b><br>
     * 快速排序
     * 
     * @param array
     * @return
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月24日 下午11:33:48 <br>
     *       <b>Version:</b> 1.0
     */
    public static int[] quickSort(int[] array) {
        if (array != null) {
            return quickSort(array, 0, array.length - 1);
        }

        return null;
    }

    private static int[] quickSort(int[] array, int beg, int end) {
        if (beg >= end || array == null) {
            return null;
        }

        int p = partition(array, beg, end);
        quickSort(array, beg, p - 1);
        quickSort(array, p + 1, end);

        return array;
    }

    /**
     * 找到分界点
     * 
     * @param array
     * @param beg
     * @param end
     * @return
     */
    private static int partition(int[] array, int beg, int end) {
        int last = array[end];
        int i = beg - 1;

        for (int j = beg; j <= end - 1; j++) {
            if (array[j] <= last) {
                i++;
                if (i != j) {
                    array[i] = array[i] ^ array[j];
                    array[j] = array[i] ^ array[j];
                    array[i] = array[i] ^ array[j];
                }
            }
        }

        if ((i + 1) != end) {
            array[i + 1] = array[i + 1] ^ array[end];
            array[end] = array[i + 1] ^ array[end];
            array[i + 1] = array[i + 1] ^ array[end];
        }

        return i + 1;
    }

    /**
     * 
     * <b>Description:</b><br>
     * 堆排序
     * 
     * @param array
     * @return
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月24日 下午11:34:18 <br>
     *       <b>Version:</b> 1.0
     */
    public static int[] heapSort(int[] array) {
        if (array == null) {
            return null;
        }
        MaxHeap h = new MaxHeap();
        h.init(array);

        for (int i = 0; i < array.length; i++) {
            h.remove();
        }

        System.arraycopy(h.queue, 1, array, 0, array.length);

        return array;
    }

    private static class MaxHeap {

        void init(int[] data) {
            this.queue = new int[data.length + 1];
            for (int i = 0; i < data.length; i++) {
                queue[++size] = data[i];
                fixUp(size);
            }
        }

        private int   size = 0;

        private int[] queue;

        public int get() {
            return queue[1];
        }

        public void remove() {
            SortUtils.swap(queue, 1, size--);
            fixDown(1);
        }

        // fixdown
        private void fixDown(int k) {
            int j;
            while ((j = k << 1) <= size) {
                if (j < size && queue[j] < queue[j + 1]) {
                    j++;
                }

                // 不用交换
                if (queue[k] > queue[j]) {
                    break;
                }

                SortUtils.swap(queue, j, k);
                k = j;
            }
        }

        private void fixUp(int k) {
            while (k > 1) {
                int j = k >> 1;
                if (queue[j] > queue[k]) {
                    break;
                }

                SortUtils.swap(queue, j, k);
                k = j;
            }
        }
    }

}
