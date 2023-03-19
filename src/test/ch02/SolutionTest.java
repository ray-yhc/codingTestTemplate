package ch02;

import org.junit.jupiter.api.Test;

import static ch02.Template.calResult;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void 히든케이스찾기() throws Exception {
        //given
        int[] nList = {3,3,3,3,3};
        assertThat(calResult(nList, 5,0)).isEqualTo("5555");
    }
    @Test
    void 히든케이스찾기2() throws Exception {
        //given
        String N = "3334133";
        int[] nList = getArray(N);
        assertThat(calResult(nList, 4,3)).isEqualTo("3333444");
    }
    @Test
    void 히든케이스찾기3() throws Exception {
        //given
        String N = "433313";
        int[] nList = getArray(N);
        assertThat(calResult(nList, 4,3)).isEqualTo("344444");
    }
    @Test
    void 히든케이스찾기4() throws Exception {
        //given
        String N = "33323";
        int[] nList = getArray(N);
        assertThat(calResult(nList, 4,3)).isEqualTo("4444");
    }


// No. 2 testcase
// input || Expedted
// 3333 0 5 || 555
// 3413 3 4 || 3344
// 433313 3 4 || 344444
// 505 9 5 || 99

    int[] getArray(String N) {
        int[] nList = new int[N.length()];
        for (int i = 0; i < N.length(); i++) {
            nList[i] = (N.charAt(i) - '0');
        }
        return nList;
    }



}