package leetcode.QskMpc202302病毒传播模型;


class QskMpc202302 {

    public int getCovidCount(int n, int m, int k) {
        int mod = 1000000007;
        long result = 0;
        //定义a[i]为第i天新增的人数，i从1开始
        //根据规律则有 a[i] = a[i - k + 1] + a[i - k + 2] + ... + a[i - m]
        //推理可得 第i天康复的人数为a[i - k]
        long[] a = new long[1001];
        //第0天新增人数为0，为方便计算用
        a[0] = 0;
        //第1天新增人数为1
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            int beginIndex = i - k + 1;//第i-k天新增的人已经痊愈，可跳过
            if (beginIndex < 0) {
                beginIndex = 0;
            }
            int endIndex = i - m;
            if (endIndex < 0) {
                endIndex = 0;
            }
            for (int j = beginIndex; j <= endIndex; j++) {
                a[i] += a[j];
                a[i] = a[i] % mod;
            }
        }
        //痊愈的人数
        long recover = 0;
        for (int i = 1; i <= n; i++) {
            if (i - k > 0) {
                recover = a[i - k];
            }
            result += a[i] - recover;
            result = result % mod;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        //2 <= n <= 1000
        //1 <= m < k <= n
        //输入: n = 5, m = 2, k = 3
        //输出：2
        QskMpc202302 qskMpc202302 = new QskMpc202302();
        System.out.println(qskMpc202302.getCovidCount(5, 2, 3));

        //输入: n = 4, m = 1, k =3
        //输出：6
        qskMpc202302 = new QskMpc202302();
        System.out.println(qskMpc202302.getCovidCount(4, 1, 3));

        //输入: n = 10, m = 3, k =6
        //输出：11
        qskMpc202302 = new QskMpc202302();
        System.out.println(qskMpc202302.getCovidCount(10, 3, 6));

        //检查1：
        //输入: n = 15, m = 4， k =8
        //27
        qskMpc202302 = new QskMpc202302();
        System.out.println(qskMpc202302.getCovidCount(15, 4, 8));

        //检查2：
        //输入: n = 50, m = 2， k =10
        //707663757
        System.out.println(qskMpc202302.getCovidCount(50, 2, 10));

        //检查3：
        //输入: n = 888, m = 5， k =12
        //725601028
        System.out.println(qskMpc202302.getCovidCount(888, 5, 12));
    }
}
