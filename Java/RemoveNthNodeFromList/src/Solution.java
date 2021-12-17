import java.util.ArrayList;

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		ArrayList<ListNode> list = new ArrayList<>();
		int i = 0;
		while (head != null) {
			list.add(head);
			head = head.next;
		}
		if (list.size() == 1)
			return null;
		if (list.size() - n != 0)
			list.get(list.size() - n - 1).next = list.get(list.size() - n - 1).next.next;
//        list.remove(list.size() - n);
		else
			return list.get(1);
		return list.get(0);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}