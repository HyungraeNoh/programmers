package exercise.all.lvl2.changeBracket;/**
 * 1. FileName	: ChangeBracket.java
 * 2. Package	: programmers
 * 3. Comments	:
 * 4. Author	: hr.noh
 * 5. DateTime	: 2021-12-22 오후 1:37
 * 6. History	:
 * -----------------------------------------------------------------
 * Date		 |	Name			|	Comment
 * -------------  -----------------   ------------------------------
 * 2021-12-22		 | hr.noh			|	최초작성
 * -----------------------------------------------------------------
 * <p>
 * 1. 메소드명: ChangeBracket
 * 2. 클래스명: ChangeBracket
 * 3. 작성자명: hr.noh
 * 4. 작성일자: 2021-12-22
 */

import java.util.LinkedList;
import java.util.List;

/**
 * PRE
 * 1. 설명
 *  괄호 변경
 *  "균형잡힌 괄호 문자열" p가 매개변수로 주어질 때, 주어진 알고리즘을 수행해 "올바른 괄호 문자열"로 변환한 결과를 return 하도록 solution 함수를 완성해 주세요.
 *
 * PRE
 *  <용어의 정의>
 *  '(' 와 ')' 로만 이루어진 문자열이 있을 경우, '(' 의 개수와 ')' 의 개수가 같다면 이를 균형잡힌 괄호 문자열이라고 부릅니다.
 *  그리고 여기에 '('와 ')'의 괄호의 짝도 모두 맞을 경우에는 이를 올바른 괄호 문자열이라고 부릅니다.
 *  예를 들어, "(()))("와 같은 문자열은 "균형잡힌 괄호 문자열" 이지만 "올바른 괄호 문자열"은 아닙니다.
 *  반면에 "(())()"와 같은 문자열은 "균형잡힌 괄호 문자열" 이면서 동시에 "올바른 괄호 문자열" 입니다.
 *  '(' 와 ')' 로만 이루어진 문자열 w가 "균형잡힌 괄호 문자열" 이라면 다음과 같은 과정을 통해 "올바른 괄호 문자열"로 변환할 수 있습니다.
 *      1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
 *      2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며
 *          , v는 빈 문자열이 될 수 있습니다.
 *      3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
 *          3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
 *      4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
 *          4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
 *          4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
 *          4-3. ')'를 다시 붙입니다.
 *          4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
 *          4-5. 생성된 문자열을 반환합니다.
 *
 *  <매개변수 설정>
 *  p는 '(' 와 ')' 로만 이루어진 문자열이며 길이는 2 이상 1,000 이하인 짝수입니다.
 *  문자열 p를 이루는 '(' 와 ')' 의 개수는 항상 같습니다.
 *  만약 p가 이미 "올바른 괄호 문자열"이라면 그대로 return 하면 됩니다
 */
public class ChangeBracket {

    static String resultValue;
    public ChangeBracket(String resultValue){
        resultValue = this.resultValue;
    }

    public static void main(String args[]){
        String p = "(()())()";
        String result = "(()())()";
        String p2 = ")(";
        String result2 = "()";
        String p3 = "()))((()";
        String result3 = "()(())()";

        resultValue = solution(p3);
        System.out.println("solution : "+resultValue);
        if(resultValue.equals(result3)){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }
    }

    public static String solution(String p) {
        String answer = p.replaceAll(" ", "");
        int left=0, right=0;
        String u,v;
        if(answer.equals(null) || answer.equals(""))
            return answer;

        List<String> pList = new LinkedList<>();

        for(int i=0;i<p.length(); i++){
            p.charAt(i);
        }

        for(char arr : p.toCharArray()){
            pList.add(arr+"");
            if("(".equals(arr)){
                left++;
            }else{
                right++;
            }

            if(left == 0 && right > 0 ){

            }
        }
        makeString(p);

        System.out.println("pList : "+pList);


        return "";
    }

    public static String makeString(String p){
        String result = "";
        convt(result);
        return "";
    }

    public static String convt(String u){

        return convt(u);
    }
}
