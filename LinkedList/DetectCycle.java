public class DetectCycle {

	public ListNode detectCycle(ListNode head) {
		int length = 0;

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				length = lengthCycle(slow);
				break;
			}
		}

		if (length == 0) {
			return null;
		}

		// find the start node
		ListNode f = head;
		ListNode s = head;

		while (length > 0) {
			s = s.next;
			length--;
		}

		// keep moving both forward and they will meet at cycle start
		while (f != s) {
			f = f.next;
			s = s.next;
		}
		return s;
	}
}
